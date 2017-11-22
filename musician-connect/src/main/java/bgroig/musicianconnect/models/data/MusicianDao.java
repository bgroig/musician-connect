package bgroig.musicianconnect.models.data;

import bgroig.musicianconnect.models.Musician;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by bgroig on 7/4/2017.
 */
@Repository
@Transactional
public interface MusicianDao extends CrudRepository<Musician, Integer> {

}
