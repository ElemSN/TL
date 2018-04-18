#include<iostream> 
using namespace std;
class Product{
public:
	virtual void Do()=0;
};
class ProductA:public Product{
public:
	void Do(){
		cout<<"ProductA Do"<<endl;
	}
};
class ProductB:public Product{
public:
	void Do(){
		cout<<"ProductB Do"<<endl;
	}
};
class ProductC :public Product{
public:
	void Do(){
		cout<<"ProductC Do"<<endl;
	}
};
class Factory{
private:
	Product* product;
public:
	Factory(Product* t){
		product=t;
	}
	void send(){
		product->Do();
	}
};
int main(void){
	Factory* fact;
	fact=new Factory(new ProductA());
	fact->send(); 
}
