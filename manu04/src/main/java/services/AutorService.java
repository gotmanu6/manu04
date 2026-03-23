package services;

import models.AutorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AutorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorModel> findAll() {
        return autorRepository.findAll();
    }

    public AutorModel criarAutor(AutorModel autorModel) {
        return autorRepository.save(autorModel);
    }

    public Optional<AutorModel> findById(Long id) {
        return autorRepository.findById(id);
    }

    public AutorModel atualizar(Long id, AutorModel autorModel) {
        AutorModel model = autorRepository.findById(id).get();
        model.setNome(autorModel.getNome());
        model.setData(autorModel.getData());
        model.setNacionalidade(autorModel.getNacionalidade());

        return autorRepository.save(model);
    }

    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }
}