package andres.learning.CRUD.authentication.controller.model;

public class User {
    private int id;
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String country;
    private String technology;

    public User() {

    }

    /**
     * This constructor is used when the app will do a:
     *      *Read
     *      *Update
     *      *Delete
     * Because to this operations is necessarily have the id of the User
     */

    public User(int id, String name, String lastName, String userName,
                String password, String country, String technology) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.technology = technology;
    }

    /**
     * This constructor is used when the app will do a:
     *      *Create
     * Because to this operations is not necessarily have the id of the User
     */

    public User(String name, String lastName, String userName,
                String password, String country, String technology) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.technology = technology;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }


    public String completeUserInformation() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", technology='" + technology + '\'' +
                '}';
    }

    public String userInformation() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", country='" + country + '\'' +
                ", technology='" + technology + '\'' +
                '}';
    }
}

