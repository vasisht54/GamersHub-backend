package jpa.server.backend.daos;

import java.util.List;

import jpa.server.backend.models.Game;
import jpa.server.backend.models.GameGroup;

public interface GameDao {

  Game createGame(Game game);

  Game findGameById(Integer gameId);

  List<Game> findAllGames();

  void deleteGame(Integer gameId);

  Game updateGame(Game game, Integer gameId);

  Game findGameByName(String name);
}
