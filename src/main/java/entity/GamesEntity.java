package entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "games", schema = "public", catalog = "login")
public class GamesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    //@Column(name = "date_of_game")
    @Column(name = "date_of_game", columnDefinition = "DATE")
    private Date dateOfGame;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfGame() {
        return dateOfGame;
    }

    public void setDateOfGame(Date dateOfGame) {
        this.dateOfGame = dateOfGame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamesEntity that = (GamesEntity) o;
        return id == that.id && Objects.equals(dateOfGame, that.dateOfGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfGame);
    }
}
