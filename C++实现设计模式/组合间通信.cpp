#include<iostream>
#include<vector>
using namespace std;

 class Base{
	public :
		virtual	void fun()=0;
};
class D1:public Base{

	public :
		void fun(){
			cout<<"D1"<<endl;
		}
};
class D2:public Base{
	public :
		void fun(){
			cout<<"D2"<<endl;
		}
};
class D3:public Base{
	public :
		void fun(){
			cout<<"D3"<<endl;
		}
};
class Fac{
	private: 
		vector<Base *> vac;
	public :
		/*
		函数作用：将其压进vector容器中 
		函数参数：Base*指向的地址
		无返回值 
		*/ 
		void Add(Base *t){
			vac.push_back(t);
		}
		/*
		函数作用：打印vector中的东西 
		无函数参数
		无返回值 
		*/  
		void Show(){
			vector<Base*>::iterator it;
			for(it=vac.begin();it!=vac.end();it++){
				(*it)->fun();
			}
		}
};
int main(void){
	Fac* f=new Fac();
	D1 *d1=new D1();
	D2 *d2=new D2();
	D3 *d3=new D3(); 
	f->Add(d1);
	f->Add(d2);
	f->Add(d3);
	f->Show();
	return 0;
} 
