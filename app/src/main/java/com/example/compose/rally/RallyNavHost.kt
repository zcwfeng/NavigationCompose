package com.example.compose.rally

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.rally.ui.accounts.AccountsScreen
import com.example.compose.rally.ui.accounts.SingleAccountScreen
import com.example.compose.rally.ui.bills.BillsScreen
import com.example.compose.rally.ui.overview.OverviewScreen

/**
 * @author zcwfeng
 * @version 将 NavHost 提取到 RallyNavHost$
 * @des
 * @date 2022/10/26 6:47 PM
 * @updateAuthor $
 * @updateDes
 */

@Composable
fun RallyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Overview.route,
        modifier = modifier
    ) {
        composable(route = Overview.route) {
            OverviewScreen(
                onClickSeeAllAccounts = {
                    navController.navigateSingleTopTo(Accounts.route)
                },
                onClickSeeAllBills = {
                    navController.navigateSingleTopTo(Bills.route)
                },
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(accountType)
                }
            )
        }
        composable(route = Accounts.route) {
            AccountsScreen(
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(accountType)
                }
            )
        }
        composable(route = Bills.route) {
            BillsScreen()
        }
        composable(
            route = SingleAccount.routeWithArgs,
            arguments = SingleAccount.arguments,
            deepLinks = SingleAccount.deepLinks
        ) { navBackStackEntry ->
            val accountType =
                navBackStackEntry.arguments?.getString(SingleAccount.accountTypeArg)
            SingleAccountScreen(accountType)
        }
    }
}



/**
navigateSingleTopTo 扩展函数中可供您使用的一些其他选项：
launchSingleTop = true - 如上所述，这可确保返回堆栈顶部最多只有给定目的地的一个副本
在 Rally 应用中，这意味着，多次重按同一标签页不会启动同一目的地的多个副本
popUpTo(startDestination) { saveState = true } - 弹出到导航图的起始目的地，以免在您选择标签页时在返回堆栈上构建大型目的地堆栈
在 Rally 中，这意味着，在任何目的地按下返回箭头都会将整个返回堆栈弹出到“Overview”屏幕
restoreState = true - 确定此导航操作是否应恢复 PopUpToBuilder.saveState 或 popUpToSaveState 属性之前保存的任何状态。请注意，如果之前未使用要导航到的目的地 ID 保存任何状态，此项不会产生任何影响
这意味着，重按同一标签页会保留屏幕上之前的数据和用户状态，而无需重新加载
 */
fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // popUpTo每次返回键弹出堆栈都会回到基本的第一个导航目的地Overview
        popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
    }

private fun NavHostController.navigateToSingleAccount(accountType: String) {
    this.navigateSingleTopTo("${SingleAccount.route}/$accountType")
}
