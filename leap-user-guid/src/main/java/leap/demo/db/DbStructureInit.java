/**
 * 
 */
package leap.demo.db;

import leap.core.AppContext;
import leap.core.AppContextInitializable;
import leap.core.annotation.Bean;
import leap.db.Db;
import leap.db.model.DbColumn;
import leap.db.model.DbColumnBuilder;
import leap.db.model.DbTableBuilder;

/**
 * 初始化数据结构
 * @author kael
 *
 */
@Bean
public class DbStructureInit implements AppContextInitializable{
	
	private Db db = null;
	
	public DbStructureInit(){}
	
	@Override
	public void postInit(AppContext context) throws Throwable {
		if(null == db)
			db = context.getBeanFactory().getBean(Db.class);
		
		init();
	}
	
	public void init(){
		if(!db.checkTableExists("leap_user"))
			initTable();
	}
	
	public void initTable(){
		if(!db.getDialect().supportsColumnComment()){
			return;
		}
		try{
			DbColumn loginId = DbColumnBuilder.varchar("login_id", 50).setComment("用户登录账号").setPrimaryKey(true).build();
			DbColumn name = DbColumnBuilder.varchar("user_name", 50).setComment("用户名称").build();
			DbColumn password = DbColumnBuilder.varchar("password", 50).setComment("用户密码").build();
			
			DbTableBuilder table = new DbTableBuilder("leap_user")
					.addColumn(loginId).addColumn(name).addColumn(password);

			db.cmdCreateTable(table.build()).execute();
		}catch(Exception e){
			throw e;
		}
	}
}
