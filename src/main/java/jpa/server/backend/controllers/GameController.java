package jpa.server.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jpa.server.backend.models.Game;
import jpa.server.backend.services.GameService;

@RestController
@CrossOrigin(origins = "*")
public class GameController {

  @Autowired
  private GameService gameService;

  @DeleteMapping("/api/game/{gameId}")
  public void deleteGame(@PathVariable int gameId) {
    this.gameService.deleteGame(gameId);
  }

  @GetMapping("/api/games")
  public List<Game> findAllGames() {
    return gameService.findAllGames();
  }

  @GetMapping("/api/game/{gameId}")
  public Game findGameById(@PathVariable int gameId) {
    return gameService.findGameById(gameId);
  }

  @PostMapping("/api/game")
  public Game createGame(@RequestBody Game game) {
    return gameService.createGame(game);
  }

  @PutMapping("api/game")
  public Game updateGame(@RequestBody Game game) {
    return gameService.updateGame(game);
  }


  @GetMapping("/api/games/{name}")
  public Game findGameByName(@PathVariable String name) {return gameService.findGameByName(name); }
}
