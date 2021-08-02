package andres.learning.CRUD.authentication.controller.model;

public class ResponseUser {

    private int id;
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String country;
    private String technology;

    public ResponseUser() {

    }

    /*public ResponseUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.country = user.getCountry();
        this.technology = user.getTechnology();
    }*/

    public ResponseUser(User user) {
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.userName = user.getUserName();
        this.country = user.getCountry();
        this.technology = user.getTechnology();
    }

    @Override
    public String toString() {
        return "ResponseUser{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", country='" + country + '\'' +
                ", technology='" + technology + '\'' +
                '}';
    }
}

