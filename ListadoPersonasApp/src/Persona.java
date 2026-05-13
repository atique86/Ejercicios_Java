public class Persona {
    private int id;
    private String nombre;
    private String telefono;
    private String email;
    private static int numeroPersonas;

    // Constructor vacío
    public Persona(){
        this.id = ++Persona.numeroPersonas;
    }

    // Constructor con argumentos
    public Persona(String nombre, String telefono, String email){
        this(); // Llamado a constructor vacío
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}' + super.toString(); // LLamado método de la clase padre
    }

    public static void main(String[] args) {
        Persona personaUno = new Persona("Juan Perez", "55443322","juan@mail.com");
        System.out.println(personaUno);
    }
}
