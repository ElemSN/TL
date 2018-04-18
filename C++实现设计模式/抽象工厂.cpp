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
class FactoryA:public Factory{
public:
	FactoryA(Product* t):Factory(t){
	} 	
}; 
class FactoryB:public Factory{
public:
	FactoryB(Product* t):Factory(t){
	} 	
};
class FactoryC:public Factory{
public:
	FactoryC(Product* t):Factory(t){
	} 	
};
int main(void){
	Factory* fact;
	fact=new FactoryA(new ProductA());
	fact->send(); 
}
