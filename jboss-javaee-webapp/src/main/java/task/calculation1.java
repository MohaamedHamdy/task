package task;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity 
public class calculation1 {
	
	private int num1,num2;
	private String operation;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	
	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}
	
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
