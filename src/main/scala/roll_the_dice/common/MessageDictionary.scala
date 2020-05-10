package roll_the_dice.common

import java.io.Serializable

object MessageDictionary {

  case class StartGame(assignedTurn: Turn, startingState: MatchState, goalPoints: Int) extends Serializable

  case object Roll extends Serializable

  case class NextTurn(currentTurn: Turn) extends Serializable

  case class Win(team: Team) extends Serializable
}
