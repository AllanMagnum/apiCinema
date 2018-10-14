package br.com.verx.virtualstore.domain.movie;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@Getter
@Entity
@Table(name = "SESSION_TIME", schema = "VTE")
public class SessionTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SESSION_TIME")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_SESSION")
    private Session session;

    @NotNull
    @Column(name = "PRICE")
    private final BigDecimal price;

    @NotNull
    @Column(name = "AVAILABLE_ASSENTS")
    private Integer availableAssents;

    @NotNull
    @Column(name = "SESSION_TIME")
    private final LocalDateTime sessionTime;

    public SessionTime(final BigDecimal price, @NotNull final LocalDateTime sessionTime) {
        this.price = price;
        this.sessionTime = sessionTime;
        this.availableAssents = 50;
    }

    private SessionTime() {
        this(null, null);
    }

    public Long getSessionTimeAsTimestamp() {
        return sessionTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public BigDecimal getSubTotal(final Integer amountAssents) {
        return price.multiply(new BigDecimal(amountAssents));
    }

}
