package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "game_history", schema = "public", catalog = "login")
public class GameHistoryEntity {
    @Basic
    @Column(name = "id")
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_game")
    private int idGame;
    @Basic
    @Column(name = "id_user")
    private int idUser;
    @Basic
    @Column(name = "rank")
    private Integer rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameHistoryEntity that = (GameHistoryEntity) o;
        return id == that.id && idGame == that.idGame && idUser == that.idUser && Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idGame, idUser, rank);
    }
}
