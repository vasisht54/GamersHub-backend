package jpa.server.backend.daos;

import java.util.List;

import jpa.server.backend.models.Game;
import jpa.server.backend.models.GameGroup;

public interface GameDao {

  Game createGame(Game game);

  List<GameGroup> getGameGroups(Integer userId);


  Game findGameById(Integer gameId);

  List<Game> findAllGames();

  void deleteGame(Integer gameId);

  Game updateGame(Game game);

  Game findGameByName(String name);
}
