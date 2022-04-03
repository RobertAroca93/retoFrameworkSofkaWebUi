package co.com.myStore.webproject.test.model;

public class ContactUsModel {

  private String Email_Adress;
  private String Subject_Heading;
  private String Message;


    public String getEmail_Adress() {
        return Email_Adress;
    }

    public void setEmail_Adress(String email_Adress) {
        Email_Adress = email_Adress;
    }

    public String getSubject_Heading() {
        return Subject_Heading;
    }

    public void setSubject_Heading(String subject_Heading) {
        Subject_Heading = subject_Heading;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
