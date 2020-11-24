package cz.bruzina.endecapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Encoding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String setFrom;
    private String setTo;

    protected Encoding() {
    }

    public Encoding(String name, String setFrom, String setTo) {
        this.name = name;
        this.setFrom = setFrom;
        this.setTo = setTo;
    }

    @Override
    public String toString() {
        return String.format("Encoding[id=%d, name='%s', from='%s, to=%s']", id, name, setFrom, setTo);
    }

    public Long getId() {
        return id;
    }

    public String getNamex() {
        return name;
    }

    public String setFrom() {
        return setFrom;
    }

    public String getTox() {
        return setTo;
    }

}
