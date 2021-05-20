package rmit.fotogram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmit.fotogram.repository.LikesRepository;

@Service
public class LikesServiceImplement implements LikesService {

    private final LikesRepository likesRepository;

    @Autowired
    public LikesServiceImplement(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

    // TODO: override methods

}
