#include<iostream>
using namespace std;
class Base{
	public:
		Base(){
		}
		virtual void method()=0;
		virtual ~Base(){
		}
};
class Droxy:public Base{
	private:Base* pb;
	public :
		Droxy(Base* pb){
			this->pb=pb;
		}
		void method(){
			pb->method();
		}
		~Droxy(){
			delete pb;
		}
};
class source:public Base{
	public:
		void method(){
			cout<<"source"<<endl;
		}
		~source(){
			cout<<"~source"<<endl;
		}
};
int main(void){
	Base *s=new source();
	Droxy* d=new Droxy(s);
	d->method();
	delete d;
}
