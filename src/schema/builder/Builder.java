package schema.builder;

/**
 * 一个抽象接口，规范产品哥哥组成部分的建造，不涉及创建部分
 */
public abstract class Builder {

	public abstract void builderPartA();

	public abstract void builderPartB();

	public abstract Product getResult();
}
