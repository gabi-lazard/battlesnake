package com.duda.battlesnake

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class BattlesnakeController {

    @GetMapping
    fun getBattleSnake(): GetBattleSnakeResponse {
        return GetBattleSnakeResponse()
    }

    @PostMapping("start")
    fun startGame(@RequestBody startGameObject: StartGameObject): Unit {

    }

    @PostMapping("move")
    fun move(@RequestBody startGameObject: StartGameObject): MoveResponse {
        return MoveResponse("up", "moving UP!!!!!!")
    }

    @PostMapping("end")
    fun end (@RequestBody startGameObject: StartGameObject): Unit {

    }
}

data class MoveResponse(val move: String, val shout: String)

//enum class Move{UP, DOWN, RIGHT, LEFT}

data class StartGameObject(
    val game: Game,
    val turn: Int,
    val board: Board,
    val you: BattleSnake
)

data class BattleSnake(
    val id: String,
    val name: String,
    val health: Int,
    val body: List<Coordinate>,
    val latency: String,
    val head: Coordinate,
    val length: Int,
    val shout: String,
    val squad: String
)


data class Board(
    val height: Int,
    val width: Int,
    val food: List<Coordinate>,
    val hazards: List<Coordinate>,
    val snakes: List<BattleSnake>
)

data class Coordinate(val x: Int, val y: Int)


data class Game(
    val id: String,
    val ruleset: Ruleset,
    val timeout: Int,
    val source: String
)


data class Ruleset(
    val name: String,
    val version: String,
    val settings: RuleSetSettings
)

data class RuleSetSettings(
    val foodSpawnChance: Int,
    val minimumFood: Int,
    val hazardDamagePerTurn: Int,
    val royale: Royale,
    val squad: Squad
)

data class Squad(
    val allowBodyCollisions: Boolean,
    val sharedElimination: Boolean,
    val sharedHealth: Boolean,
    val sharedLength: Boolean,
)

data class Royale(val shrinkEveryNTurns: Int)


data class GetBattleSnakeResponse(
    val apiversion: String = "1",
    val author: String = "gabi-lazard",
    val color: String = "#FF0000",
    val head: String = "bendr",
    val tail: String = "bolt",
    val version: String = "0.01",
)