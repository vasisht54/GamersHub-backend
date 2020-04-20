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

  @DeleteMapping("/api/games/{gameId}")
  public int deleteGame(@PathVariable int gameId) {
    return this.gameService.deleteGame(gameId);
  }

  @GetMapping("/api/games")
  public List<Game> findAllGames() {
    return gameService.findAllGames();
  }

  @GetMapping("/api/games/{gameId:[0-9]+}")
  public Game findGameById(@PathVariable int gameId) {
    return gameService.findGameById(gameId);
  }

  @PostMapping("/api/games")
  public Game createGame(@RequestBody Game game) {
    return gameService.createGame(game);
  }

  @PutMapping("api/games/{gameId}")
  public Game updateGame(@RequestBody Game game, @PathVariable Integer gameId) {
    return gameService.updateGame(game, gameId);
  }

  @GetMapping("/api/games/{name:[a-zA-z]+}")
  public Game findGameByName(@PathVariable String name) {
    String actualGameName = name.replaceAll("%20", " ");
    return gameService.findGameByName(actualGameName);
  }
}
