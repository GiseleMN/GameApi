package my.Top.Game.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.Top.Game.domain.model.Game;
import my.Top.Game.domain.model.GameRepository;
import my.Top.Game.service.GameService;
import my.Top.Game.service.exception.BusinessException;
import my.Top.Game.service.exception.NoContentException;

@Service
public class GameServiceImpl implements GameService {

	
	@Autowired
	private GameRepository repository;
	
	@Override
	public List<Game> findAll() {
		List<Game> games = repository.findAll();
		return games;
	}

	@Override
	public Game findById(Long id) {
		Optional<Game> game = repository.findById(id);
		return game.orElseThrow(()-> new NoContentException());
	}
	
	@Override
	public void insert(Game game) {
		if(Objects.nonNull(game.getId())) {
			throw new BusinessException("O Id e diferente de null na inclusao");
		}
		repository.save(game);
	}

	@Override
	public void update(Long id, Game game) {
		Game gameDb = findById(id);
		if(gameDb.getId().equals(game.getId())) {
			repository.save(game);
		}else {
			throw new BusinessException("Os Ids para a alteracao sao divergentes");
		}
	}

	@Override
	public void delete(Long id) {
		Game gameDb = findById(id);
		repository.delete(gameDb);
		
	}
	
	
	

}
