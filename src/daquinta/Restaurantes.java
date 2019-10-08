/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daquinta;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "restaurantes", catalog = "daquinta_teste", schema = "")
@NamedQueries({
    @NamedQuery(name = "Restaurantes.findAll", query = "SELECT r FROM Restaurantes r"),
    @NamedQuery(name = "Restaurantes.findById", query = "SELECT r FROM Restaurantes r WHERE r.id = :id"),
    @NamedQuery(name = "Restaurantes.findByNome", query = "SELECT r FROM Restaurantes r WHERE r.nome = :nome"),
    @NamedQuery(name = "Restaurantes.findByMorada", query = "SELECT r FROM Restaurantes r WHERE r.morada = :morada"),
    @NamedQuery(name = "Restaurantes.findByTelefone", query = "SELECT r FROM Restaurantes r WHERE r.telefone = :telefone"),
    @NamedQuery(name = "Restaurantes.findByNif", query = "SELECT r FROM Restaurantes r WHERE r.nif = :nif"),
    @NamedQuery(name = "Restaurantes.findByGps", query = "SELECT r FROM Restaurantes r WHERE r.gps = :gps"),
    @NamedQuery(name = "Restaurantes.findByHistorico", query = "SELECT r FROM Restaurantes r WHERE r.historico = :historico")})
public class Restaurantes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Morada")
    private String morada;
    @Column(name = "Telefone")
    private Integer telefone;
    @Column(name = "NIF")
    private Integer nif;
    @Column(name = "GPS")
    private String gps;
    @Column(name = "Historico")
    private String historico;

    public Restaurantes() {
    }

    public Restaurantes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        String oldMorada = this.morada;
        this.morada = morada;
        changeSupport.firePropertyChange("morada", oldMorada, morada);
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        Integer oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        Integer oldNif = this.nif;
        this.nif = nif;
        changeSupport.firePropertyChange("nif", oldNif, nif);
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        String oldGps = this.gps;
        this.gps = gps;
        changeSupport.firePropertyChange("gps", oldGps, gps);
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        String oldHistorico = this.historico;
        this.historico = historico;
        changeSupport.firePropertyChange("historico", oldHistorico, historico);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurantes)) {
            return false;
        }
        Restaurantes other = (Restaurantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "daquinta.Restaurantes[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
