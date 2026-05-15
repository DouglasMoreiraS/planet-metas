package br.com.planet.metas.service;

import java.util.List;


@org.springframework.stereotype.Service
public abstract class BaseService<T, R>{

    public abstract T salvar(T object);
    public abstract List<T> salvar(List<T> list);
    public abstract List<T> listar();
    public abstract List<T> listarAPI();
    protected abstract List<T> parseResponse(R response);
    

}
