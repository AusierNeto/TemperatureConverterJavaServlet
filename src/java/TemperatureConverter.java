/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/conversion/*")
public class TemperatureConverter extends HttpServlet {
    private int fahrenheitToCelsiusConversion(int value) {
        return ((value - 32) * 5) / 9;
    }

    private int celsiusToFahrenheitConversion(int value) {
        return ((value * 9) / 5) + 32;
    }
    
    private int getTemperatureConversion(int value, String conversionType) {
        if (conversionType.equals("FahrenheitToCelsius"))
            return fahrenheitToCelsiusConversion(value);
        else if (conversionType.equals("CelsiusToFahrenheit")) {
            return celsiusToFahrenheitConversion(value);
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
            
            if (temperatureType.equals("CelsiusToFahrenheit"))
                out.println("<h1>Your temperature in Fahrenheit is " + temperatureOutput + "</h1>");
            else if (temperatureType.equals("FahrenheitToCelsius"))
                out.println("<h1>Your temperature in Celsius is " + temperatureOutput + "</h1>");
            
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

