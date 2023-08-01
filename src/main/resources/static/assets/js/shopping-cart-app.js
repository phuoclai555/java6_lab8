let app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl",function ($scope,$http){
    $scope.cart ={
        items:[],
        add(id){
            var item = this.items.find(item => item.id === id);
            if(item){
                item.qty++;
                this.saveToLocalStorage();
            }else {
                $http.get(`/rest/products/${id}`).then(resp =>{
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
        remove(id){
            var index = this.items.findIndex(item => item.id === id);
            if(this.items[index].qty <= 1){
                this.items.splice(index,1);
                this.saveToLocalStorage();
            }else {
                this.items[index].qty-=1;
                this.saveToLocalStorage();
            }

        },
        clear(){
            this.items = []
            this.saveToLocalStorage();
        },
        // thanh tien 1 sp
        amt_of(item){},
        // tong so luong sp trong gio hang
        get count(){
            return this.items
                .map(item => item.qty)
                .reduce((total,qty) => total += qty,0);
        },
        // tong tien cac mat hang trong gio hang
        get amount(){
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total,qty) => total += qty,0);
        },
        // luu gio hang vao
        saveToLocalStorage(){
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);
        },
        loadFromLocalStorage(){
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }

    $scope.cart.loadFromLocalStorage();

    $scope.order = {
        createDate: new Date(),
        address:"",
        account:{username:$("#username").text()},
        get orderDetails(){
          return $scope.cart.items.map(item =>{
              return{
                  product:{id:item.id},
                  price:item.price,
                  quantity:item.qty
              }
          })
        },
        purchase(){
            var order = angular.copy(this);
            $http.post("/rest/orders",order).then(resp =>{
                alert("Đặt hàng thành công")
                $scope.cart.clear();
                location.href = "/order/detail/" + resp.data.id;
            }).catch(error =>{
                alert("Đặt hàng lỗi")
                console.log(error)
            })
        }
    }
})