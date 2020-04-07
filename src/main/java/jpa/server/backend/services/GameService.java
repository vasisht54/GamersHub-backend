package jpa.server.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import jpa.server.backend.daos.GameDao;
import jpa.server.backend.models.Game;
import jpa.server.backend.models.GameGroup;
import jpa.server.backend.repositories.GameRepository;

@Service
public class GameService implements GameDao {

  @Autowired
  private GameRepository gameRepository;

  @Override
  public Game createGame(Game game) {
    return gameRepository.save(game);
  }

  @Override
  public List<GameGroup> getGameGroups(Integer userId) {
    return gameRepository.findById(userId).get().getGroupsList();
  }

  @Override
  public Game findGameById(Integer gameId) {
    return gameRepository.findById(gameId).get();
  }

  @Override
  public List<Game> findAllGames() {
    Iterable returnedGames = gameRepository.findAll();
    List<Game> listToReturn = new ArrayList<>();

    for (Object game : returnedGames) {
      listToReturn.add((Game) game);
    }

    return listToReturn;
  }

  @Override
  public void deleteGame(Integer gameId) {
    gameRepository.deleteById(gameId);
  }

  @Override
  public Game updateGame(Game game) {
    return gameRepository.save(game);
  }

  @Override
  public Game findGameByName(String name) {
    return gameRepository.findGameByName(name);
  }
}
