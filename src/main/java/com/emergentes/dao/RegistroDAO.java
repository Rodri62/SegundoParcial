package com.emergentes.dao;

import com.emergentes.modelo.Registro;
import java.util.List;

public interface RegistroDAO {
    public void insert (Registro registro) throws Exception;
    public void update(Registro registro) throws Exception;
    public void delete(int id) throws Exception;
    public List<Registro> getAll() throws Exception;
    public Registro getById(int id) throws Exception;

    
}
