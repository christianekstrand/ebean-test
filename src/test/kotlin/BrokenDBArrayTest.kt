
import com.youcruit.ebean.list.kotlin.test.BrokenParent
import com.youcruit.ebean.list.kotlin.test.Parent
import com.youcruit.ebean.list.kotlin.test.ParentType
import io.ebean.EbeanServer
import io.ebean.EbeanServerFactory
import io.ebean.config.ServerConfig
import io.ebean.config.dbplatform.h2.H2Platform
import org.h2.Driver
import org.junit.Before
import org.junit.Test
import kotlin.test.assertNotNull

class BrokenDBArrayTest {

    private lateinit var config: ServerConfig
    private lateinit var server: EbeanServer

    @Before
    fun setupEbean() {
        config = ServerConfig()
        config.name = "youcruit-test"
        config.dataSourceConfig.url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"
        config.classes = listOf(BrokenParent::class.java)
        config.dataSourceConfig.username = "sa"
        config.dataSourceConfig.password = "blank"
        config.dataSourceConfig.driver = Driver::class.java.name
        config.isDefaultServer = true
        config.databasePlatform = H2Platform()
        config.isDdlGenerate = true
        config.isDdlRun = true
        server = EbeanServerFactory.create(config)
    }

    @Test
    fun testSetup() {
        val parent = Parent(parentTypes = mutableSetOf(ParentType.FATHER))
        server.save(parent)
        assertNotNull(parent.id)
    }
}