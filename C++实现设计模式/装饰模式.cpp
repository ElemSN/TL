#include<iostream>
using namespace std;
class Base{
	private:
		Base * next;
	public:
		Base(Base* next){
			this->next=next;
		}
		Base(){
		}
		virtual void fun(){
			if(next!=NULL)
				next->fun();
		}
		virtual~Base(){
			cout<<"~Base"<<endl;
			delete(next);
		}
};
class PecordtorA:public Base{
	public:
		PecordtorA(){
		} 
		PecordtorA(Base* next):Base(next){
		}
		void fun(){
			cout<<"PecordtorA"<<endl;
			Base::fun();
		}
		~PecordtorA(){
			cout<<"~PecordtorA"<<endl;
		}
}; 
class PecordtorB:public Base{
	public:
		PecordtorB(){
		} 
		PecordtorB(Base* next):Base(next){
		}
		void fun(){
			cout<<"PecordtorB"<<endl;
			Base::fun();
		}
		~PecordtorB(){
			cout<<"~PecordtorB"<<endl;
		}
};
class Decordeor:public Base{
	public:
		Decordeor(){
		}
		Decordeor(Base* next):Base(next){
		}
		~Decordeor(){
			cout<<"~Decordeor"<<endl;
		};
		
};
class DecordeorA:public Decordeor{
	public:
		DecordeorA(){
		}
		DecordeorA(Base* next):Decordeor(next){
		}
		void fun(){
			cout<<"DecoratorA"<<endl;
			Base::fun();
		}
		virtual~DecordeorA(){
			cout<<"~DecordeorA"<<endl;
		}
}; 
class DecordeorB:public Decordeor{
	public:
		DecordeorB(){
		}
		DecordeorB(Base* next):Decordeor(next){
		}
		void fun(){
			cout<<"DecoratorB"<<endl;
			Base::fun();
		}
		~DecordeorB(){
			cout<<"~DecordeorB"<<endl;
		}
}; 
int main(){
	Base *head=NULL;
	head=new DecordeorB(head);
	head=new DecordeorA(head);
	head=new PecordtorA(head);
	head->fun();
	delete(head);
} 
