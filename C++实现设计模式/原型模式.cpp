#include<iostream> 
using namespace std;
class Protetype{
protected:
	int x,y;
public:
	virtual Protetype * clone()=0;
};
class ConeretoPrototype:public Protetype{
public:
	ConeretoPrototype(){
		x=0;
		y=0;
	}
	ConeretoPrototype(int x,int y){
		this->x=x;
		this->y=y;
	}
	ConeretoPrototype(Protetype &t){
		*this=t; 
	}
	Protetype * clone(){
		return new ConeretoPrototype(*this);
	}	
};
int main(void){
	Protetype* p;
	Protetype* p1;
	p=new ConeretoPrototype(1,5);
	p1=p->clone();
}

