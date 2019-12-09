//implemented interface
public class EntryClass<I,A> implements Entry<I,A> {
	 public I id;  //id
     public A age;  // age
     public String birthdate;
     public String tempid; //just controller

     public EntryClass(I id,A age,String birthdate) {
        this.id=id;
        this.age=age;
        this.birthdate=birthdate;
        
       
     }

     // public methods of the Entry interface
     public I getId() { return id; }
     
     public A getAge() { return age; }
     
     public String getBirthDate() { return birthdate; }
     
     public void setTempId(String fields) {this.tempid=fields; }
     
     public void setId(I id) { this.id=id; }
     
     public void setAge(A age) {  this.age=age;  }
     
     public void setBirthDate(String birthdate) { this.birthdate=birthdate; }
     
     
     
     
}
