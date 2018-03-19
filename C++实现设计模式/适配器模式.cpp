#include<iostream>
using namespace std;
class Adeptee{
	public:
		void methad(){
			cout<<"Adaptee class"<<endl;
		}
		~Adeptee(){
			cout<<"~Adaptee"<<endl;
		} 
};
class AdepterBase{
	public:
		virtual	void methad()=0;
		virtual ~AdepterBase(){
		}
};
class AdepterA:public AdepterBase{
	public:
		void methad(){
			cout<<"AdapterA"<<endl;
		}
		~AdepterA(){
			cout<<"~AdapterA"<<endl;
		}
};
class AdepterB:public AdepterBase{
	private :Adeptee* ptee;
	public:
		AdapterB(){
			ptee=new Adeptee();
		}
		void methad(){
			ptee->methad();
		}
		~AdepterB(){
			delete ptee;
			cout<<"~AdapterB"<<endl;
			
		} 
};
class AdepterC:public AdepterBase{
	public:
		void methad(){
			cout<<"AdapterC"<<endl;
		}
		~AdepterC(){
			cout<<"~AdapterC"<<endl;
		} 
};
int main(void){
	AdepterBase* base=new AdepterB();
	base->methad(); 
	delete base;
	return 0;
}

