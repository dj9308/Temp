package practice1;

public class Ploynomial {
	/*
	 * 화요일 다항식 관련 문제를 풀었던 경험이 크게 작용.
	 * 
	 * 덧셈은 무난히 끝냈지만 곱셈은 시간이 많이 소요됨
	 * 
	 * 구조는 만들었지만 계속 원래답과 다른 답이 나오기 시작
	 * 
	 * 이유를 알수없어 결국 답안지 참고. 왜그런지 생각했으나 명확한 답은 나오지 못함.
	 */
	public static void main(String[] args) {
		polynomial();
	}

	public static void polynomial() {
		float[] a_coef = { 1, 1 };
		int[] a_exp = { 1, 0 };

		float[] b_coef = { 5, -10, 5, -10 };
		int[] b_exp = { 3, 2, 1, 0 };

		Polynomial a = new Polynomial();
		Polynomial b = new Polynomial();

		Polynomial result;
		for (int i = 0; i < a_exp.length; i++) {
			a.newTerm(a_coef[i], a_exp[i]);
		}
		for (int i = 0; i < b_exp.length; i++) {
			b.newTerm(b_coef[i], b_exp[i]);
		}
		result = a.add(b);
		System.out.print("다항식 a + 다항식 b = ");
		result.print();
		
		result = a.Mul(b);
		System.out.print("다항식 a * 다항식 b = ");
		result.print();
	}
}

class Term {
	float coef;
	int exp;

	Term() {
		this.coef = 0;
		this.exp = 0;
	}
}


class Polynomial {
	Term termArray[];
	int terms;

	public Polynomial() {
		this.terms = 0;
		this.termArray = new Term[10];
		for (int i = 0; i < termArray.length; i++) {
			termArray[i] = new Term();
		}
	}

	void print() {
		String result = "";
		for (int i = 0; i < this.termArray.length; i++) {
			if (this.termArray[i].coef == 0) {
				continue;
			} else {
				if (i != 0) {
					result = result + " + " + this.termArray[i].coef + "x^" + this.termArray[i].exp;
				} else {
					result = this.termArray[i].coef + "x^" + this.termArray[i].exp;
				}
			}
		}
		if (result == "")
			System.out.println("0");
		else
			System.out.println(result);
	}

	void newTerm(float coef, int exp) {
		if (this.termArray.length == this.terms) {
			Term temp[] = new Term[this.termArray.length * 2];
			for (int i = 0; i < this.termArray.length; i++) {
				temp[i] = termArray[i];
			}
			this.termArray = temp;
		}
		this.termArray[this.terms].coef = coef;
		this.termArray[this.terms++].exp = exp;
	}

	Polynomial add(Polynomial b) {
		Polynomial result = new Polynomial();
		int i=0;
		int j=0;
		while(i<this.terms && j<b.terms) {
				if(this.termArray[i]==b.termArray[j]) {
					result.newTerm(termArray[i].coef + b.termArray[j].coef
							, termArray[i].exp);
					i++;j++;
				}else if(this.termArray[i].exp>b.termArray[j].exp) {
					result.newTerm(b.termArray[i].coef, b.termArray[j].exp);
					j++;
				}else if(this.termArray[i].exp<b.termArray[j].exp) {
					result.newTerm(this.termArray[i].coef,this.termArray[i].exp);;
					i++;
				}
			}
				for( ; i<terms;i++) {
					result.newTerm(this.termArray[i].coef, this.termArray[i].exp);
				}
				for( ; j<terms;j++) {
					result.newTerm(this.termArray[j].coef, this.termArray[j].exp);
				}
				return result;
		}  

	public Polynomial Mul(Polynomial b) {
		Polynomial result = null;
		Polynomial c;
		for (int i = 0; i < terms; i++) {
			c = new Polynomial();
			for (int j = 0; j < b.terms; j++) {
				c.newTerm(termArray[i].coef * b.termArray[j].coef, termArray[i].exp + b.termArray[j].exp);
			}
			if (i == 0) {
				result = c;
			} else {
				result = c.add(result);
			}
		}
		return result;
	}
}