package br.com.planet.metas.dto;

public class FiltroColaboradorDTO {

    private Long id;
    private Long idSetor;

    public FiltroColaboradorDTO(Long id, Long idSetor) {
        this.id = id;
        this.idSetor = idSetor;
    }

    public FiltroColaboradorDTO(Long idSetor) {
        this.idSetor = idSetor;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Long idSetor) {
        this.idSetor = idSetor;
    }

}
