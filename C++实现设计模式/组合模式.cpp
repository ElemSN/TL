#include<iostream>
#include<vector>
using namespace std;
class AbstractFile{
	protected :
		string name;
	public:
		AbstractFile(string name){
			this->name=name;
		}
		AbstractFile(){
			name="new"; 
		}
		virtual void out()=0;
		virtual ~AbstractFile(){};
};
class File:public AbstractFile{
	public:
		File(string name):AbstractFile(name){			
		}
		File(){
		}
		/*
		�������ã���ӡ�ļ���
		�޺�������
		�޷���ֵ 
		*/ 
		void out(){
			cout<<"File:"<<"  "<<name<<endl;
		}
};
class Filder:public AbstractFile{
	private: 
		vector<AbstractFile *> vec;
	public:
		Filder(string name):AbstractFile(name){
		}
		Filder(){
		}
		/*
		�������ã�����ѹ��vector������ 
		����������AbstractFile*ָ��ĵ�ַ
		�޷���ֵ 
		*/
		void Add(AbstractFile *t){
			 vec.push_back(t);
		}
		/*
		�������ã�����ӡ�ļ������ļ�����
		�޺�������
		�޷���ֵ 
		*/ 
		void out(){
			cout<<"Filder:"<<"  "<<name<<endl;
			vector<AbstractFile*>::iterator it;
			for(it=vec.begin();it!=vec.end();++it){
				(*it)->out();
			} 
		}
};
int main(void){
	Filder* root1=new Filder("root1");
	Filder* root2=new Filder("root2");
	Filder* root3=new Filder("root3");
	File* word1=new File("word1");
	File* word2=new File("word12");
	File* word3=new File("word3");
	File* word4=new File("word4");
	File* word5=new File("word5");
	File* word6=new File("word6");
	root1->Add(word1);
	root1->Add(word2);
	root1->Add(root2);
	root2->Add(word3);
	root2->Add(word4);
	root2->Add(root3);
	root3->Add(word5);
	root3->Add(word6);
	root1->out();
}
