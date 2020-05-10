package roll_the_dice.common

import java.io.Serializable

object MessageDictionary {

  @SerialVersionUID(0x1L)
  case class StartGame(assignedTurn: Turn, startingState: MatchState, goalPoints: Int) extends Serializable

  @SerialVersionUID(0x2L)
  case object Roll extends Serializable

  @SerialVersionUID(0x3L)
  case class NextTurn(currentTurn: Turn) extends Serializable

  @SerialVersionUID(0x4L)
  case class Win(team: Team) extends Serializable
}
