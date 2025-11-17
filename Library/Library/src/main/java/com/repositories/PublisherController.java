package com.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entities.Publisher;

@RestController
@RequestMapping( "/api/Library" )

public class PublisherController {

    @Autowired
    PublisherRepository publisherRepository;

    
    @PostMapping
    public Publisher savPublisher( @RequestBody Publisher publisher ) {
        return publisherRepository.save( publisher );
    }

    @GetMapping
    public List<Publisher> showPublishers() {
        return publisherRepository.findAll();
    }

    @DeleteMapping
    public void deletePublisher( @PathVariable Long id ) {
        publisherRepository.deleteById(id);
    }

    
    @PutMapping( "/{id}" )
	public Publisher updatePublisher( @PathVariable Long id, @RequestBody Publisher newPublisher ) {
		Optional<Publisher> optionalPublisher = publisherRepository.findById( id );
		if ( optionalPublisher.isPresent( ) ) {
			Publisher publisher = optionalPublisher.get();
			publisher.setName( newPublisher.getName( ) );
			publisher.setAddress( newPublisher.getAddress( ) );
			publisher.setCnpj( newPublisher.getCnpj( ) );
            publisher.setPhone(newPublisher.getPhone( ));
			return publisherRepository.save( publisher );
		}
		return null;

    

    }
}

