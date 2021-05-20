package rmit.fotogram.service;

import rmit.fotogram.model.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();
    Tag findById(Long id);
    void save(Tag tag);
    void deleteById(Long id);
}
