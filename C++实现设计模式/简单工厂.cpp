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
	Factory(int n){
		switch(n){
			case 1:product=new ProductA();break;
			case 2:product=new ProductB();break;
			case 3:product=new ProductC();break;
		} 
	}
	void send(){
		product->Do();
	}
};
int main(void){
	Factory* fact;
	fact=new Factory(3);
	fact->send(); 
}
