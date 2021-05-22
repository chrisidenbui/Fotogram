package rmit.fotogram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.fotogram.model.Tag;
import rmit.fotogram.repository.TagRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImplement implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImplement(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findByName(String tagName) {
        // TODO: implement search by tag name

//        return tagRepository.findByName(tagName);
        return null;
    }

    @Override
    public Tag findById(Long id) {
        Tag tag;
        Optional<Tag> result = tagRepository.findById(id);

        if (result.isPresent()) {
            tag = result.get();
        }
        else {
            throw new RuntimeException("The tag with id = " + id + " is not found!");
        }
        return tag;
    }

    @Override
    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }
}
