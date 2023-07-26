package std.com.ec;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Main {

    static String driver;
    static String url;
    static String usuario;
    static String passwd;

    public static void main(String[] args) {

        Main app = new Main();
        Properties prop = app.loadPropertiesFile("application.properties");

        driver = prop.get("db.driverClassName").toString();
        url = prop.get("db.url").toString();
        usuario = prop.get("db.username").toString();
        passwd = prop.get("db.password").toString();
        pruebaBase();
    }

    public Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }

    public static void pruebaBase() {
        try {
            // Realizamos conexion a la base de datos
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, usuario, passwd);

            // Ingresamos la sentencia SQL SELECT query.
            String query = "SELECT * FROM usuario";

            // Creamos el statement
            Statement st = conn.createStatement();

            // Ejecutamos el query
            ResultSet rs = st.executeQuery(query);

            // Recorremos el resultset
            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String firstName = rs.getString("nombre");

                // Imprime resultado de consultas
                System.out.format("%s, %s", id, firstName);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Se encontro un problema! ");
            System.err.println(e.getMessage());
        }
    }
}