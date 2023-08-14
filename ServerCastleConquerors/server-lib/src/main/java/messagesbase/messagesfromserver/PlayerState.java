package messagesbase.messagesfromserver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import messagesbase.UniquePlayerIdentifier;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.NONE)
public final class PlayerState extends UniquePlayerIdentifier {

	@XmlElement(name = "playerUsername", required = true)
	private final String playerUsername;

	@XmlElement(name = "state", required = true)
	private final EPlayerGameState state;

	@XmlElement(name = "collectedTreasure", required = true)
	private final boolean collectedTreasure;

	public PlayerState() {
		super();
		this.playerUsername = null;
		this.collectedTreasure = false;
		this.state = null;
	}

	public PlayerState(String playerUsername, EPlayerGameState state, UniquePlayerIdentifier playerIdentifier,
	      boolean collectedTreasure) {
		super(checkNotNull(playerIdentifier, "Player identifier must not be null").getUniquePlayerID());
		this.playerUsername = checkNotNull(playerUsername, "Player username must not be null");
		this.state = checkNotNull(state, "Player state should not be null");
		this.collectedTreasure = collectedTreasure;
	}

	public String getPlayerUsername() {
		return playerUsername;
	}

	public EPlayerGameState getState() {
		return state;
	}

	@Override
	public String toString() {
		return "Player [username=" + playerUsername + ", state=" + state + ", " + super.toString() + "]";
	}
	
	public boolean hasCollectedTreasure() {
		return collectedTreasure;
	}

	private static <T> T checkNotNull(T reference, String errorMessage) {
		if (reference == null) {
			throw new IllegalArgumentException(errorMessage);
		}
		return reference;
	}
}