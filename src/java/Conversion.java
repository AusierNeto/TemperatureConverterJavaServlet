import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/conversion/*")
public class Conversion extends HttpServlet {
    private int fahrenheitToCelciusConversion(int value) {
        return ((value - 32) * 5) / 9;
    }

    private int celciusToFahrenheitConversion(int value) {
        return ((value * 9) / 5) + 32;
    }
    
    private int getTemperatureConversion(int value, String conversionType) {
        if (conversionType.equals("FahrenheitToCelcius"))
            return fahrenheitToCelciusConversion(value);
        else if (conversionType.equals("CelciusToFahrenheit")) {
            return celciusToFahrenheitConversion(value);
        }
        return -1;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String temperatureType = request.getParameter("temperature");
        int value = Integer.parseInt(request.getParameter("value"));
        int temperatureOutput = getTemperatureConversion(value, temperatureType);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet conversion</title>");
            out.println("</head>");
            out.println("<body>");
            
            if (temperatureType.equals("CelciusToFahrenheit"))
                out.println("<h1>Your temperature in Fahrenheit is " + temperatureOutput + "</h1>");
            else if (temperatureType.equals("FahrenheitToCelcius"))
                out.println("<h1>Your temperature in Celcius is " + temperatureOutput + "</h1>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet responsible to make the temperature conversion logic";
    }

}
