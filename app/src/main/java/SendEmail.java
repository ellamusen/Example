import com.sendgrid.*;
import java.io.IOException;

public class SendEmail {

    public static void main(String[] args) throws IOException {

        Email from = new Email("dani_1997@live.dk"); // Send mail til denne mail
        Email to = new Email("lail5198@edu.easj.dk"); // Send mail fra denne mail
        String subject = "Tilbudsbestilling"; // Mailens overskrift
        Content content = new Content("text/plan","Jeg ønsker et tilbud"); // Mailens indhold
        Mail mail = new Mail(from, subject, to, content); // Mailens opbygning

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY")); // SENDGRID API KEY
        Request request = new Request(); // Lav et Request objekt, der gør det muligt at sende request til API'en

        try { // Dette er vores request til API'en
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sg.api(request); // Svaret på ens request
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());

        } catch (IOException ex) {
            throw ex;
        }


    }

}
