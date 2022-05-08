import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class game extends JFrame implements ActionListener {
public int u=0,s=0,e=0,j,i=0,xx=0;

//--------------------------------------------------------
private class node {
	int x=0;int y=0; node pa=null;}
//--------------------------------------------------------
public node m[];
public node m1[];
public node mm[];
node n11;
//---------------------------------------------------------
public void mayyas(){
	if(x==0){Icon icons=new ImageIcon( "0l.GIF" );
label.setIcon(icons);}
	if(x==1){Icon icons=new ImageIcon( "1l.GIF" );
label.setIcon(icons);}
	if(x==2){Icon icons=new ImageIcon( "2l.GIF" );
label.setIcon(icons);}
	if(x==3){Icon icons=new ImageIcon( "3l.GIF" );
label.setIcon(icons);}
	if(x==4){Icon icons=new ImageIcon( "4l.GIF" );
label.setIcon(icons);}

	if(y==0){Icon i1=new ImageIcon( "g0.GIF" );
l2.setIcon(i1);}
	if(y==1){Icon i1=new ImageIcon( "g1.GIF" );
l2.setIcon(i1);}
	if(y==2){Icon i1=new ImageIcon( "g2.GIF" );
l2.setIcon(i1);}
	if(y==3){Icon i1=new ImageIcon( "g3.GIF" );
l2.setIcon(i1);}
};
//----------------------------------------------------------
boolean isempty(){
	if(u==0)return true;
	else return false;}
//----------------------------------------------------------
void push(node n)
{for(j=0;j<s;j++)
if(m1[j].x==n.x&&m1[j].y==n.y)
e=1;
if(e!=1)
{
m[u]=n;m1[s]=n;
u++;s++;}e=0;}
//----------------------------------------------------------
node pop(){
node n1;
n1=new node();
n1=m[u-1];
u--;
return n1;
}
//----------------------------------------------------------
void expand(node n10){
node n2;n2=new node();node n3;n3=new node();node n4;n4=new node();node n5;n5=new node();
node n6;n6=new node();node n7;n7=new node();node n8;n8=new node();node n9;n9=new node();
//fill 4-gallon jug
if(n10.x!=4){
	n2.x=4;
	n2.y=n10.y;
	n2.pa=n10;
    push(n2);


}
//-----------------------------------------------------------
//fill 3-gallon jug
if(n10.y!=3){
	n3.x=n10.x;
	n3.y=3;
  n3.pa=n10;
  push(n3);
}
//---------------------------------------------------------
//empty 4-gallon jug
if(n10.x!=0){
	n4.x=0;
	n4.y=n10.y;
	n4.pa=n10;
    push(n4);

}
//-----------------------------------------------------------
//empty 3-gallon jug
if(n10.y!=0){
	n5.x=n10.x;
	n5.y=0;
	n5.pa=n10;
    push(n5);

}
//-----------------------------------------------------------
//5
if(4-n10.x>=n10.y&&n10.x!=4&&n10.y!=0){
	n6.x=n10.x+n10.y;
	n6.y=0;
	n6.pa=n10;
    push(n6);

}
//-----------------------------------------------------------
//6
if(3-n10.y>=n10.x&&n10.x!=0&&n10.y!=3){
	n7.x=0;
	n7.y=n10.x+n10.y;
	n7.pa=n10;
    push(n7);
}
//-----------------------------------------------------------
//7
if(n10.y!=0&&4-n10.x<=n10.y){
	n8.x=4;
	n8.y=n10.y-(4-n10.x);
	n8.pa=n10;
    push(n8);
}
//-------------------------------------------------------------
//8
if(n10.x!=0&&3-n10.y<=n10.x){
	n9.x=n10.x-(3-n10.y);
	n9.y=3;
	n9.pa=n10;
    push(n9);
}}
//----------------------------------------------------------
public node dfs(){
	if(xx==2)
	{s=0;u=0;xx=0;}
	node n;n=new node();node nz;nz=new node(); node nx;nx=new node(); node nc;nc=new node();
	node nv;nv=new node(); node nb;nb=new node(); node nn;nn=new node(); node nm;nm=new node();
	node na;na=new node(); node ns;ns=new node(); node nd;nd=new node(); node nf;nf=new node();
	m1[s]=n;m[u]=n;s++;u++;
while(true)
{
n=pop();
if(n.x==2)return n;
expand(n);
}
}
//-----------------------------------------------------------------------

private JButton b1,b2,b3,b4,b5,b6,b7,b8;
private JPanel p,p1,p2,p3,p4,p5,p6;
private Icon icons,i1,bug2,bug3,bug4,bug5,bug6,bug7;
private JLabel label,l1,l2,ll,l3;
public int x,y;
   public game()
   {
      super( "water-jug problem made by ENG mayyas " );
      Container c = getContentPane();
      n11=new node();
      m=new node[20];
      m1=new node[20];
      mm=new node[20];
      p = new JPanel();
     p.setLayout(
         new GridLayout(8,1) );
    p1 = new JPanel();
     p1.setLayout(
        new GridLayout(3,1) );
      p6 = new JPanel();
     p6.setLayout(
		        new FlowLayout() );
        p1.add(p6);
     p4 = new JPanel();
     p4.setLayout(
        new GridLayout(1,1) );
        p1.add(p4);
      p5 = new JPanel();
     p5.setLayout(
		        new FlowLayout() );
        p1.add(p5);
 //----------------------------------------------
label = new JLabel(  );
Icon icons=new ImageIcon( "0l.GIF" );
label.setIcon(icons);
p4.add(label);
//-------------------------------------------------------
l2 = new JLabel(  );
Icon i1=new ImageIcon( "g0.GIF" );
l2.setIcon(i1);
p4.add(l2);
//-----------------------------------------------------
 b8 = new JButton( "next" );
      b8.addActionListener(this);
            p5.add( b8 );
            b8.setVisible( false );
//-----------------------------------------------------
l1=new JLabel( "                        choose the operation:" );
p.add( l1 );
 //----------------------------------------------------
 Icon bug4=new ImageIcon( "v2.GIF" );
      b1 = new JButton( bug4 );
      b1.addActionListener(this);
            p.add( b1 );
     //------------------------------------------------
     Icon bug5=new ImageIcon( "v3.GIF" );
      b2 = new JButton(bug5  );
      b2.addActionListener(this);
            p.add( b2 );
     //------------------------------------------------
     Icon bug6=new ImageIcon( "v4.GIF" );
      b3 = new JButton( bug6 );
      b3.addActionListener(this);
           p.add( b3 );
      //-----------------------------------------------
      Icon bug7=new ImageIcon( "v5.GIF" );
       b4 = new JButton( bug7 );
       b4.addActionListener(this);
                p.add( b4 );
      //-----------------------------------------------
       Icon bug2=new ImageIcon( "v6.GIF" );
       b5 = new JButton(bug2);

       b5.addActionListener(this);
                 p.add( b5 );
      //-----------------------------------------------
      Icon bug3=new ImageIcon( "v1.GIF" );
       b6 = new JButton(bug3);
       b6.addActionListener(this);
                 p.add( b6 );
     //----------------------------------------------------
      b7 = new JButton("The solution");
	        b7.addActionListener(this);
                 p.add( b7 );
     //---------------------------------------------------
      c.add( p,BorderLayout.WEST );   // East position

      c.add(p1, BorderLayout.EAST );   // West position

            setSize( 750,500 );
           setResizable(false);
            show();
         }
  //----------------------------------------------------------------------

    public void actionPerformed(ActionEvent e){

if(e.getSource()==b1)
     {  x=4;
     mayyas();
     if(x==2){JOptionPane.showMessageDialog( this,
         "you are win...ENG mayyas " )
         ;x=0;y=0;mayyas();}
         }

if(e.getSource()==b2)
     {y=3;
     mayyas();
	      if(x==2){JOptionPane.showMessageDialog( this,
	          "you are win...ENG mayyas ")
         ;x=0;y=0;mayyas();}
     }

if(e.getSource()==b3)
     { x=0 ;
     mayyas();
	      if(x==2){JOptionPane.showMessageDialog( this,
	          "you are win...ENG mayyas " )
         ;x=0;y=0;mayyas();}
     }

if(e.getSource()==b4)
     {  y=0;
     mayyas();
	      if(x==2){JOptionPane.showMessageDialog( this,
	          "you are win...ENG mayyas " )
         ;x=0;y=0;mayyas();}
     }


if(e.getSource()==b5)
 {     if(y==0||x==4);
 //---------------------------------------
     else if(x==0||x==1){
		 x=y+x;
		 y=0; }
 //---------------------------------------
	else if(x==3){x=4;y=y-1;}
//--------------------------------------------------
    else{
		if(y==1){x=3;y=0;}
		else{x=4;y=y-2;}}
//------------------------------------------
	mayyas();
	     if(x==2){JOptionPane.showMessageDialog( this,
	         "you are win...ENG mayyas " )
         ;x=0;y=0;mayyas();}
	}
//-----------------------------------------------------
if(e.getSource()==b6)
     {
		 if(y==3||x==0);
//-------------------------------------
	else if(y==0){
		if(x==4){y=3;x=1;}
			else{y=x;x=0;}}
//-----------------------------------------------
   else if(y==2){
	   if(x==1){y=3;x=0;}
	   else {x=x-(y/2);y=3;}}
//--------------------------------
   else{
	   if(x==4||x==3){x=x-2*y;y=3;}
	   else{y=x+1;x=0;}}
}
mayyas();
     if(x==2){JOptionPane.showMessageDialog( this,
         "you are win...ENG mayyas " )
         ;x=0;y=0;mayyas();}
//------------------------------------------------------
//b7
if(e.getSource()==b7)
 {b8.setVisible(true);
 n11=dfs();
x=0;y=0;mayyas();
while(n11.pa!=null)
{mm[i]=n11;
n11=n11.pa;
i++;}
mm[i]=n11;}
  //----------------------------------------------------------
  if(e.getSource()==b8)
{ i--;
   x=mm[i].x;
   y=mm[i].y;
   mayyas();
   if(i==0){
	   JOptionPane.showMessageDialog( this,
         "finish...ENG mayyas " );
       b8.setVisible(false);
       x=0;y=0;i=0;mayyas();
       xx++;
         }}
         }
//---------------------------------------------------------

         public static void main( String args[] )
         {
           game app = new game();

            app.addWindowListener(
               new WindowAdapter() {
                  public void windowClosing( WindowEvent e )
                  {
                     System.exit( 0 );
                  }
               }
            );
         }
}
