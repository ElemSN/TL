#include<iostream> 
using namespace std;
class MyClass{
    private:
        int x,y;
    public:
        MyClass(){
            x=0;
            y=0;
        }
        MyClass(int x,int y){
            this->x=x;
            this->y=y;
        }
        MyClass(int & t){
            * this=t;
        }
}; 
