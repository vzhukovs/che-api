import io.github.che_incubator.che.api.*
import io.github.che_incubator.devfile.kubernetes.client.models.V1alpha2DevWorkspaceSpecTemplate
import io.kubernetes.client.openapi.apis.CoreV1Api
import io.kubernetes.client.openapi.apis.CustomObjectsApi
import io.kubernetes.client.util.ClientBuilder
import org.yaml.snakeyaml.LoaderOptions
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import java.nio.file.Path
import java.nio.file.Paths
import io.kubernetes.client.openapi.Configuration as k8sConfiguration

fun main(args: Array<String>) {

//    val k8sClient = ClientBuilder.cluster().build()
//    k8sConfiguration.setDefaultApiClient(k8sClient)
//
//    val k8sApi = CoreV1Api()
//
//    val k8sCustomObjectsApi = CustomObjectsApi()
//    k8sCustomObjectsApi.patchNamespacedCustomObject()
//
//    val devfileController = DevfileController(
//        DevfileContentProvider(
//            IODevfileContent(Configuration::getDevWorkspaceFlattenedDevfilePath),
//            DevfileContentParser(Configuration::getDevWorkspaceFlattenedDevfileParsingStrategy)
//        ),
//        K8sDevfileContentRetainer()
//    )
//    println(devfileController.getTemplateObject())

    val templateObject = ApiClient.DevfileClient.getTemplateObject()
    println(templateObject)
}

