This project was made 10th of April 2023

Project Title: Web Service Clients Application

Description

This Java application provides a GUI that displays information about the current weather, exchange rate of the country's currency against a user-specified currency, and the exchange rate of the Polish złoty against the specified country's currency. It also displays a Wikipedia page describing the city. The application uses the OpenWeatherMap API for weather data, the ExchangeRate-API for currency exchange rates, and parses NBP's website for złoty exchange rates.

Adding Gson Library to Your Project

To parse JSON responses in the project, we use the Gson library. If you're not using a build management tool like Maven or Gradle, you'll need to manually add the Gson library to your project's classpath. Follow these steps to add the Gson JAR file:

Download the Gson JAR: Visit the Gson releases page and download the latest gson-main JAR file.
Create a Library Directory:
Create a new directory named libs within the root of your project directory.
Place the downloaded gson-main JAR file into this libs directory.
Add the JAR to Your Project's Classpath in IntelliJ IDEA:
Right-click on your project in the Project Explorer and select Open Module Settings.
In the Project Settings dialog, go to the Libraries tab.
Click the + button and select Java.
Navigate to the libs directory, select the Gson JAR file you downloaded, and click OK.
Click Apply and then OK to close the dialog.
After completing these steps, your project should recognize Gson classes, allowing you to import com.google.gson.JsonObject and com.google.gson.JsonParser in your code without any issues.



How to Run

Ensure Java is installed on your system.
Clone the repository to your local machine.
Add the Gson library to your project's classpath.
Run the Main class to launch the application.
Project Structure

Main.java: The entry point of the application.
Service.java: Contains the logic to fetch weather and currency data.
Weather.java: Represents the weather information (note: ensure this class uses Gson for JSON parsing).
Requirements

Java 8 or newer.
Internet access for API calls.
Gson library for JSON processing.
License

Specify the license, for example, MIT License.

